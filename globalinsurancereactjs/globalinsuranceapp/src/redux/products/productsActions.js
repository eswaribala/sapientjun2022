import axios from 'axios'

import PolicyDataService from "../services/PolicyService";
import {CREATE_POLICY} from "./types";

export const fetchProducts = () => {
  return (dispatch) => {
    dispatch(fetchProductsRequest())
    axios
      .get('http://localhost:3004/insuranceProducts')
      .then(response => {
        const products = response.data
        setTimeout(() => {  // to emulate some network delay
          dispatch(fetchProductsSuccess(products))
        }, 2000)
      })
      .catch(error => {
        dispatch(fetchProductsFailure(error.message))
      })
  }
}

export const fetchProductsRequest = () => {
  return {
    type: 'FETCH_PRODUCTS_REQUEST'
  }
}

export const fetchProductsSuccess = insProducts => {
  return {
    type: 'FETCH_PRODUCTS_SUCCESS',
    payload: insProducts
  }
}

export const fetchProductsFailure = error => {
  return {
    type: 'FETCH_PRODUCTS_FAILURE',
    payload: error
  }
}
//Step3

export const createPolicy = (values) => async (dispatch) => {
  try {
    const res = await PolicyDataService.create(values);

    dispatch({
      type: CREATE_POLICY,
      payload: res.data,
    });

    return Promise.resolve(res.data);
  } catch (err) {
    return Promise.reject(err);
  }
};
