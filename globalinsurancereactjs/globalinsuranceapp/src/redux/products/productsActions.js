import axios from 'axios'

export const fetchProducts = () => {
  return (dispatch) => {
    dispatch(fetchProductsRequest())
    axios
      .get('http://localhost:3004/products')
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

export const fetchProductsSuccess = products => {
  return {
    type: 'FETCH_PRODUCTS_SUCCESS',
    payload: products
  }
}

export const fetchProductsFailure = error => {
  return {
    type: 'FETCH_PRODUCTS_FAILURE',
    payload: error
  }
}
