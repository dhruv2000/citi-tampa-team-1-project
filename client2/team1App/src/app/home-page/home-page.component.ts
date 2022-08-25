import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  processedOrders!: Observable<Array<Order>>;
  subscriptionOrders = new Subscription();
  totalValue!: any;
  values!: Array<Order>;


  subscribeToUpdates(): void {
    this.subscriptionOrders = this.orderService.orderUpdater.subscribe(data => {
      console.log(data);
      data.forEach(element => {
      
        this.totalValue += element.price * element.num_shares;
      });
    })
  }


  constructor(private orderService: OrderService) { }

  

  ngOnInit(): void {
    this.processedOrders = this.orderService.getProcessedOrders();
    this.subscribeToUpdates();
    this.orderService.getProcessedOrdersWithSubscribe()
    // this.processedOrders.subscribe((data)=>
    // this.values = data)
    // console.log(this.processedOrders);
    // console.log(this.totalValue);
    // this.values.forEach(element => {
    //   this.totalValue += element.price * element.num_shares;
    // });

    this.orderService.getProcessedOrders().subscribe((res)=>{
      this.values = res;  //<--see that here player_list is the "object"
      //here you can use 
      console.log(this.values);
      let temp = 0;
      for(var value of this.values){
        temp += value.price * value.num_shares;;
      } 
      this.totalValue = temp;
   })
  }
}
