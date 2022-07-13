import React from "react";
import {useState} from "react";
import { InputText } from 'primereact/inputtext';
import { Calendar } from 'primereact/calendar';
import { Button } from 'primereact/button';
import axios from "axios";
import './create.css'
import validate from "./formvalidationrules";
const RestAPIUrl='http://localhost:4000';
//react hook version 16.8
export default function Create(props){


    const { policyNo: propsPolicyNo, policyHolderName:propsPolicyHolderName, fromDate: propsFromDate,
        toDate:propsToDate, sumAssured:propsSumAssured,dispatch } = props;
    //define fields
    const [policyNo, setPolicyNo] = useState( propsPolicyNo,0);
    const [policyHolderName, setPolicyHolderName] = useState( propsPolicyHolderName,'');
    const [fromDate, setFromDate] = useState( propsFromDate,'');
    const [toDate, setToDate] = useState( propsToDate,'');
    const [sumAssured, setSumAssured] = useState( propsSumAssured,0);
    const [inputs, setInputs]= useState({});
    const [errors, setErrors] = useState({
        policyNo: 0,
        policyHolderName: "",
        fromDate:"",
        toDate:"",
        sumAssured:0
    });
    const [isAddDisabled, setIsAddDisabled] = React.useState(false);
  /* const handleOnBlur=(event)=>{
       const name=event.target.name;
       const value=event.target.value;
       setInputs(values=>({...values,[name]:value}))

   };
*/

   const handleOnChange=(event)=>{
       const name=event.target.name;
       const value=event.target.value;
       //console.log(name,value)
       setInputs(values=>({...values,[name]:value}))
   };

    const handleSubmit=(event)=> {
      //  if (event) event.preventDefault();
        console.log(inputs)
     //console.log(validate(inputs));
      // setErrors(validate(inputs));
        console.log(errors);
       // setIsAddDisabled(true);
       axios.post(RestAPIUrl+"/addpolicy",inputs).then(res => {
           console.log(res);

       }).catch(error => {
               throw(error);
           });

    }

    return(

        <form className="form border border-primary shadow-none p-3 rounded">
            <fieldset>
                <legend>Add Policy</legend>
                <span className="mt-5">
                    <label htmlFor="policyNo" className="form-label">Policy No</label>
                 <InputText  name="policyNo" type="number" required value={policyNo} className="form-control"
                             onChange={handleOnChange}/>
                    {errors.policyNo &&
                    <div style={{ color: "red", paddingBottom: 10 }}>
                        {errors.policyNo}</div>
                    }

                </span>
                <span className="mt-5">
                    <label htmlFor="policyHolderName" className="form-label">PolicyHolder Name</label>
                    <InputText  name="policyHolderName" required  type="text" value={policyHolderName} className="form-control"
                                onChange={handleOnChange}/>

                </span>
                    <span className="mt-5">
                         <label htmlFor="fromDate" className="form-label">From Date</label>
                         <Calendar  name="fromDate" required value={fromDate} className="w-100" onChange={handleOnChange} showIcon />


                </span>
                <span className="mt-5">
                    <label htmlFor="toDate" className="form-label">To Date</label>
                       <Calendar  name="toDate" required value={toDate} className="w-100" onChange={handleOnChange} showIcon />

                </span>
                <span className="mt-5">
                    <label htmlFor="sumAssured" className="form-label">Sum Assured</label>
                    <InputText type="number" required name="sumAssured"
                               value={sumAssured} className="form-control" onChange={handleOnChange}/>

                </span>
                <Button label="Submit" className="mt-3 form-control" aria-label="Submit"
                        disabled={isAddDisabled}   onClick={handleSubmit}

                />
                </fieldset>
        </form>

    )


}
