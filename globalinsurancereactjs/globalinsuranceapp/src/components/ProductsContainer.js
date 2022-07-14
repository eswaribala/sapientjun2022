import React, { useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { fetchProducts} from '../redux'
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';


export const ProductsContainer = () => {
  const loading = useSelector(state => state.insuranceProducts.loading)
  const error = useSelector(state => state.insuranceProducts.error)
  const products = useSelector(state => state.insuranceProducts.insuranceProducts)
  const dispatch = useDispatch()
    const columns = [
        {field: 'id', header: 'Id'},
        {field: 'code', header: 'Code'},
        {field: 'name', header: 'Name'},
        {field: 'description', header: 'Description'},
        {field: 'image', header: 'Image'},
        {field: 'price', header: 'Price'},
        {field: 'category', header: 'Category'},
        {field: 'quantity', header: 'Quantity'},
        {field: 'inventoryStatus', header: 'Inventory Status'},
        {field: 'rating', header: 'Rating'},


    ];

  useEffect(() => {
    dispatch(fetchProducts())


  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])
    const dynamicColumns = columns.map((col,i) => {
        return <Column key={col.field} field={col.field} header={col.header} />;
    });

  return loading ? (
    <h2>Loading...</h2>
  ) : error ? (
    <h2>{error}</h2>
  ) : (
    <div className="container-sm w-auto">
      <h2>Products</h2>

        <div>
            <DataTable value={products} responsiveLayout="scroll">
                {dynamicColumns}
            </DataTable>
        </div>
    </div>
  )
}
