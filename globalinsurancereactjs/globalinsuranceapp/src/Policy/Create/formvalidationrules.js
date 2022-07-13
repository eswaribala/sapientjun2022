export default function validate(values) {
    let errors = {
        policyNo: 0,
        policyHolderName: "",
        fromDate:"",
        toDate:"",
        sumAssured:0
    };
    if (values.policyNo<=0) {
        errors.policyNo = 'PolicyNo is required';
    } else if (!/\d{5}/.test(values.policyNo)) {
        errors.policyNo = 'PolicyNo is invalid';
    }
    if (!values.policyHolderName) {
        errors.policyHolderName = 'PolicyHolder Name is required';
    } else if (values.policyHolderName.length < 3) {
        errors.policyHolderName = 'PolicyHolder Name must be 4 or more characters';
    }
    if (!values.fromDate) {
        errors.fromDate = 'From Date is required';
    } else if (values.fromDate > values.toDate) {
        errors.fromDate = 'From Date cannot be after the ToDate';
    }
    if (!values.toDate) {
        errors.toDate = 'To Date is required';
    } else if (values.toDate < values.toDate) {
        errors.toDate = 'To Date cannot be before the from Date';
    }
    if (values.sumAssured<=0) {
        errors.sumAssured = 'Sum Assured required';
    } else if (!/\d{3,10}/.test(values.sumAssured)) {
        errors.sumAssured = 'Sum Assured invalid';
    }
    return errors;
};
