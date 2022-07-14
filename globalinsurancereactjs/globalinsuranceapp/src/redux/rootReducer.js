import { combineReducers } from 'redux'
import productsReducer from './products/productsReducer'

const rootReducer = combineReducers({
  products: productsReducer
})

export default rootReducer
