import { Menubar } from 'primereact/menubar';
import {items} from "../Models/menudata";
import React from 'react'
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import {Routes} from "react-router";

import './menu.css'
import Create from "../Policy/Create/create";
import {View} from "../Policy/View/view";
import {Delete} from "../Policy/Delete/delete";
import {Export} from "../Policy/Export/export";
import {ClaimCreate} from "../Claim/Create/create";
import {ClaimDelete} from "../Claim/Delete/delete";
import {ClaimEdit} from "../Claim/Edit/edit";
import {ClaimView} from "../Claim/View/view";
import {UsersNew} from "../Users/New/new";
import {UsersDelete} from "../Users/Delete/delete";
import {SearchPrint} from "../Users/Print/print";
import {SearchList} from "../Users/List/list";
import {RefundSave} from "../Refund/Save/save";
import {RefundDelete} from "../Refund/Delete/delete";
import {ArchiveRemove} from "../Archive/Remove/remove";
import {Quit} from "../Quit/quit";
const menuBar=()=>(
    <Router>
    <div className="menu">
    <Menubar model={items} />
    </div>
       { <Routes>
            <Route path="/Policy-Create" element={<Create/>}/>
            <Route path="/Policy-View" element={<View/>}/>
            <Route path="/Policy-Delete" element={<Delete/>}/>
           <Route path="/Policy-Export" element={<Export/>}/>
            <Route path="/Claim-Create" element={<ClaimCreate/>}/>
            <Route path="/Claim-Delete" element={<ClaimDelete/>}/>
            <Route path="/Claim-Edit" element={<ClaimEdit/>}/>
           <Route path="/Claim-View" element={<ClaimView/>}/>
           <Route path="/Users-New" element={<UsersNew/>}/>
           <Route path="/Users-Delete" element={<UsersDelete/>}/>
           <Route path="/Search-Print" element={<SearchPrint/>}/>
           <Route path="/Search-List" element={<SearchList/>}/>
           <Route path="/Refund-Save" element={<RefundSave/>}/>
           <Route path="/Refund-Delete" element={<RefundDelete/>}/>
           <Route path="/Archive-Remove" element={<ArchiveRemove/>}/>
           <Route path="/Quit" element={<Quit/>}/>

        </Routes>}
    </Router>
)

export default menuBar

