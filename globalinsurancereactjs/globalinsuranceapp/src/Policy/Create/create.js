import React from "react";
import {useState} from "react";
import { InputText } from 'primereact/inputtext';
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

   const handleOnBlur=(event)=>{
       const name=event.target.name;
       const value=event.target.value;
       setInputs(values=>({...values,[name]:value}))

   };


   const handleOnChange=(event)=>{
       const name=event.target.name;
       const value=event.target.value;
       setInputs(values=>({...values,[name]:value}))
   };

    return(
        <form className="">
            <fieldset>
                <legend>Add Policy</legend>
            <InputText type="number" value={policyNo} onChange={handleOnChange}/>
            <InputText type="text" value={policyHolderName} onBlur={handleOnBlur}/>
            <InputText type="date" value={fromDate} onChange={handleOnChange}/>
            <InputText type="date" value={toDate} onChange={handleOnChange}/>
            <InputText type="number" value={sumAssured} onChange={handleOnChange}/>
            </fieldset>
        </form>
    )


}
