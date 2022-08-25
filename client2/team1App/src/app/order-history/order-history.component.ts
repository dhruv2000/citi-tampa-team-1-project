import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Order } from '../order'
import { OrderService } from '../order.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {

  orders!: Observable<Array<Order>>;
  // // Items in the cart.
  // orders: Array<Order> = [];
    
  // // Fields relating to the "slice" pipe.
  // sliceStart: number;
  // sliceEnd: number;
  
  // // Field relating to the "i18nPlural" pipes.
  // messageMapping = {
  //   '=1':    'One item',
  //   'other': '# items'
  // };

  // // Fields relating to the "Add item to shopping cart" form.
  // // Orders: Array<Order> = [];
  // // selectedProduct!: Order;
  // // quantity!: number;

  constructor(private orderService: OrderService) {
    

  //   this.sliceStart = 0;
  //   this.sliceEnd = this.orders.length; 
  }

  // // Find the array index of the item with the specified id, or -1 if not found.
  // private findOrder(id: number) : number {
  //   for (var i = 0; i < this.orders.length; i++) {
  //     if (this.orders[i].id === id) {
  //       return i;
  //     }
  //   }
  //   return -1;
  // }
  
  // // Remove the item with the specified id.
  // remove(id: number) {
  //   let index = this.findOrder(id);
  //   if (index != -1) {
  //     this.orders.splice(index, 1);
  //   }
  // }
  
  // // Calculate the line cost for the item with the specified id.
  // lineCost(id: number) : number {
  //   let index = this.findOrder(id);
  //   if (index != -1) {
  //     let order = this.orders[index];
  //     return order.price * order.num_shares
  //   }
  //   else {
  //     return 0;
  //   }
  // }
  
  // // Calculate the total cost of all lines in the cart.
  // totalCartCost() : number {
  //   let total = 0;
  //   for (let order of this.orders) {
  //     total += order.price * order.num_shares;
  //   }
  //   return total;
  // }
ngOnInit(): void {

  this.orderService.getOrders().subscribe(
    (data:any) => this.orders = data,
    (err:any) => console.log("Error")
    );
    
  //  this.add_orders = this.orderService.getOrders();
    
}

}

