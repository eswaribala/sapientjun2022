const initialState = {
  loading: false,
  insuranceProducts: [],
  error: ''
}

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case 'FETCH_PRODUCTS_REQUEST':
      return {
        ...state,
        loading: true
      }
    case 'FETCH_PRODUCTS_SUCCESS':
      console.log(action.payload);
      return {
        loading: false,
        insuranceProducts: action.payload,
        error: ''
      }
    case 'FETCH_PRODUCTS_FAILURE':
      return {
        loading: false,
        insuranceProducts: [],
        error: action.payload
      }
    default: return state
  }
}

export default reducer
