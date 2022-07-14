import React from "react";
import axios from 'axios'
export default function AddProduct(props){
    const { name: propsName, cost: propsCost, dispatch } = props;
    const [isAddDisabled, setIsAddDisabled] = React.useState(false);
    const [name, setName] = React.useState(propsName || '');
    const [cost, setCost] = React.useState(propsCost || '');
    const apiUrl='http://localhost:4000/products'
    React.useEffect(() => {
        validateForm();
    }, [name, cost]);

    const validateName = text => /[A-Za-z]{2,15}/.test(text);

    const validateForm = () => {
        setIsAddDisabled(cost <= 0 || !validateName(name));
    };

    const handleNameBlur = evt => {
        const nameValue = evt.target.value.trim();
        setName(nameValue);
    };

    const handleCostChange = evt => {
        const costValue = evt.target.value;
        setCost(costValue);
    };

    const handleSubmit = () => {
        console.log(name,cost) ;
        var product={
            'productName':name,
            'cost':cost
        }
        axios.post(apiUrl,
            product)
            .then(res => {
                console.log(res.data)
                //window.location.href="/Driver";

            })
            .catch(error => {
                throw(error);
            });
        setIsAddDisabled(true);
    };

    return (
        <form>
            <input
                type="text"
                placeholder="name"
                className="mx-auto my-2"
                onBlur={handleNameBlur}

            />
            <input
                type="number"
                className="my-2"
                onChange={handleCostChange}
                value={cost}
            />
            <input
                type="button"
                className="btn btn-primary"
                onClick={handleSubmit}
                disabled={isAddDisabled}
                value="Submit"
            />
        </form>
    );

}

