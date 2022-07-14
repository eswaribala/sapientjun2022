import { combineReducers } from 'redux'
import productsReducer from './products/productsReducer'

const rootReducer = combineReducers({
  insuranceProducts: productsReducer
})

export default rootReducer
