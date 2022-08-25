import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'addorder', component: AddOrderComponent },
  { path: 'editorders', component: EditOrderComponent },
  { path: 'viewhistory', component: OrderHistoryComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
