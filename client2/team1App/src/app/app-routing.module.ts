import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddOrderComponent } from './add-order/add-order.component';
import { EditOrdersComponent } from './edit-orders/edit-orders.component';
import { HomePageComponent } from './home-page/home-page.component';
import { OrderHistoryTableComponent } from './order-history-table/order-history-table.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'addorder', component: AddOrderComponent },
  { path: 'editorders', component: EditOrdersComponent },
  { path: 'viewhistory', component: OrderHistoryTableComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
