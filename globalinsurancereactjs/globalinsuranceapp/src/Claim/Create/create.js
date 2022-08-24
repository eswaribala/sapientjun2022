import axios from "axios";
import React, { useState, useEffect } from "react";
export const BASE_URL = "https://jsonplaceholder.typicode.com";

export const fetchUsers = async () => {
    try {
        return await axios.get(`${BASE_URL}/users`);
    } catch (e) {
        return [];
    }
};
export default function ApiCaller() {
    const [rawApiData, setRawApiData] = useState({});
    const [errorMsg, setErrorMsg] = useState('');

    const callApi = async (inputValue) => {
        try {
            const apiData= await axios.get(
                `https://cloud.iexapis.com/stable/stock/market/batch?types=chart&symbols=${inputValue}&range=3m&token=lalaccf0`
            );
            setRawApiData(apiData);
        } catch (err) {
            setErrorMsg(
                'Error occured!! ' +
                (Boolean(err.response) ? err.response.data : err.message)
            );
        }
    };

    return { rawApiData, callApi, errorMsg };
}



const useAxios = (url, setData) => {
    useEffect(
        () => {
            let mounted = true;

            const loadData = async () => {
                const result = await axios.get(url);
                if (mounted) {
                    setData(result.data);
                }
            };
            loadData();

            return () => {
                mounted = false;
            };
        },
        [url]
    );
};

export  function Fetch({ url }) {
    const [data, setData] = useState(null);
    useAxios(url, setData);

    if (!data) {
        return <span data-testid="loading">Loading data...</span>;
    }

    return <span data-testid="resolved">{data.greeting}</span>;
}
