export default function validate(values) {
    let errors = {
        policyNo: "",
        policyHolderName: "",
        fromDate:"",
        toDate:"",
        sumAssured:""
    };
    let isValid=true;
    console.log(values.policyNo);
    if (values.policyNo<=0) {
        errors.policyNo = 'PolicyNo is required';
        isValid=false
    } else if (!/\d{5,8}/.test(values.policyNo)) {
        errors.policyNo = 'PolicyNo is invalid';
        isValid=false;
    }
    if (!values.policyHolderName) {
        errors.policyHolderName = 'PolicyHolder Name is required';
        isValid=false;
    } else if (values.policyHolderName.length < 3) {
        errors.policyHolderName = 'PolicyHolder Name must be 4 or more characters';
        isValid=false;
    }
    if (!values.fromDate) {
        errors.fromDate = 'From Date is required';
        isValid=false;
    } else if (values.fromDate > values.toDate) {
        errors.fromDate = 'From Date cannot be after the ToDate';
        isValid=false;
    }
    if (!values.toDate) {
        errors.toDate = 'To Date is required';
        isValid=false;
    } else if (values.toDate < values.toDate) {
        errors.toDate = 'To Date cannot be before the from Date';
        isValid=false;
    }
    if (values.sumAssured<=0) {
        errors.sumAssured = 'Sum Assured required';
        isValid=false;
    } else if (!/\d{3,10}/.test(values.sumAssured)) {
        errors.sumAssured = 'Sum Assured invalid';
        isValid=false;
    }
    let errorObj={
        errorsValue:errors,
        status:isValid
    }
    return errorObj;
};
