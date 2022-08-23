import React, {useEffect} from "react";
import {useState} from "react";
import { InputText } from 'primereact/inputtext';
import { Calendar } from 'primereact/calendar';
import { Button } from 'primereact/button';
import axios from "axios";
import './create.css'
import validate from "./formvalidationrules";
import {useDispatch} from "react-redux";
import {createPolicy} from "../../redux/products/productsActions";
const RestAPIUrl='http://localhost:4000';
//react hook version 16.8
export default function Create(props){



    const { policyNo: propsPolicyNo, policyHolderName:propsPolicyHolderName, fromDate: propsFromDate,
        toDate:propsToDate, sumAssured:propsSumAssured } = props;
    //define fields
    const [policyNo, setPolicyNo] = useState( propsPolicyNo,0);
    const [policyHolderName, setPolicyHolderName] = useState( propsPolicyHolderName,'');
    const [fromDate, setFromDate] = useState( propsFromDate,'');
    const [toDate, setToDate] = useState( propsToDate,'');
    const [sumAssured, setSumAssured] = useState( propsSumAssured,0);
    const [inputs, setInputs]= useState({});
    const [errors, setErrors] = useState({
        policyNo: "",
        policyHolderName: "",
        fromDate:"",
        toDate:"",
        sumAssured:""
    });

    const [isAddDisabled, setIsAddDisabled] = React.useState(false);
    const [isSubmitting, setIsSubmitting] = useState(false);

    //STEP1
    const dispatch = useDispatch();
    //useEffect checks render commit
    /*useEffect(() => {
        if (Object.keys(errors).length === 0 && isSubmitting) {
            validate(inputs);
        }
    }, [errors]);
*/

  /* const handleOnBlur=(event)=>{
       const name=event.target.name;
       const value=event.target.value;
       //spread attributes
       setInputs(values=>({...values,[name]:value}))

   };
*/

   const handleOnChange=(event)=>{
       const name=event.target.name;
       const value=event.target.value;
       //console.log(name,value)
       setInputs(values=>({...values,[name]:value}))
         if((inputs.policyNo>0)&&(inputs.policyHolderName.length>5)&&(inputs.sumAssured>0))
             setIsAddDisabled(true);
   };

    const handleSubmit=(event)=> {
      event.preventDefault();

        console.log(inputs)
     //console.log(validate(inputs));
      let response= validate(inputs)
       setErrors(response.errorsValue);
        console.log(errors);
      let isValid=response.status;


       if(isValid) {
           setIsAddDisabled(false);
           /*
           axios.post(RestAPIUrl + "/addpolicy", inputs).then(res => {
               console.log(res);
               setPolicyNo("")
               setPolicyHolderName("")
               setFromDate("")
               setToDate("")
               setSumAssured("")
           }).catch(error => {
               throw(error);
           });
           */

           //Step6
           dispatch(createPolicy(inputs))
               .then(data => {
                   console.log(data);
                   setPolicyNo("")
                   setPolicyHolderName("")
                   setFromDate("")
                   setToDate("")
                   setSumAssured("")
               })
               .catch(e => {
                   console.log(e);
               });


       }

    }


    return(
        <div>
        <form onSubmit={handleSubmit}  className="form border border-primary shadow-none p-3 rounded">
            <fieldset>
                <legend>Add Policy</legend>
                <span className="mt-5">
                    <label htmlFor="policyNo" className="form-label">Policy No</label>
                 <InputText  name="policyNo" type="number"  value={policyNo}
                             className="form-control"
                             onChange={handleOnChange}/>
                    {errors.policyNo &&
                    <div style={{ color: "red", paddingBottom: 10 }}>
                        {errors.policyNo}</div>
                    }

                </span>
                <span className="mt-5">
                    <label htmlFor="policyHolderName" className="form-label">PolicyHolder Name</label>
                    <InputText  name="policyHolderName"  type="text" value={policyHolderName}
                                className="form-control"
                                onChange={handleOnChange}/>
                    {errors.policyHolderName &&
                    <div style={{ color: "red", paddingBottom: 10 }}>
                        {errors.policyHolderName}</div>
                    }
                </span>
                    <span className="mt-5">
                         <label htmlFor="fromDate" className="form-label">From Date</label>
                         <Calendar  name="fromDate" value={fromDate} className="w-100" onChange={handleOnChange} showIcon />

                        {errors.fromDate &&
                        <div style={{ color: "red", paddingBottom: 10 }}>
                            {errors.fromDate}</div>
                        }
                </span>
                <span className="mt-5">
                    <label htmlFor="toDate" className="form-label">To Date</label>
                       <Calendar  name="toDate"  value={toDate} className="w-100" onChange={handleOnChange} showIcon />
                    {errors.toDate &&
                    <div style={{ color: "red", paddingBottom: 10 }}>
                        {errors.toDate}</div>
                    }
                </span>
                <span className="mt-5">
                    <label htmlFor="sumAssured" className="form-label">Sum Assured</label>
                    <InputText type="number"  name="sumAssured"
                               value={sumAssured} className="form-control" onChange={handleOnChange}/>
                    {errors.sumAssured &&
                    <div style={{ color: "red", paddingBottom: 10 }}>
                        {errors.sumAssured}</div>
                    }

                </span>
                <Button label="Submit" className="mt-3 form-control" aria-label="Submit"
                        type="submit" disabled={!isAddDisabled} />
                </fieldset>
        </form>

        </div>
    )


}
