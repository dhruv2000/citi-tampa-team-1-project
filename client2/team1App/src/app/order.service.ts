import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  orderUpdater = new Subject<Array<Order>>();

  objectBody: any = {
    "order_type" : "buy",
    "price" : 57.34,
    "time_of_day" : "2021-09-12 14:02:29",
    "asset" : "stock",
    "status_code" : 3,
    "num_shares" : 21,
    "ticker" : "TSLA"
};

jsonBody: JSON = <JSON>this.objectBody;

// private baseUrl: string = 'http://localhost:8080/api/orders/';
private baseUrl: string = 'http://tampa-team-project-1-tampa-team-project-1.openshift21.conygre.com/api/orders';

  constructor(private http: HttpClient) { }

getOrders(): Observable<Array<Order>>  {
    return this.http.get(this.baseUrl) as Observable<Array<Order>>;
}

getProcessedOrders(): Observable<Array<Order>>  {
  return this.http.get(this.baseUrl + "/processed") as Observable<Array<Order>>;
}

getProcessedOrdersWithSubscribe(): void {
  this.http.get<Array<Order>>(this.baseUrl + "/processed").subscribe(data => {
    this.orderUpdater.next(data);
  })
  
}

getOrderById(id: number): Observable<Order> {
    return this.http.get(`${this.baseUrl}/${id}`) as Observable<Order>;
}

orderFullfillment(): Observable<Order> {
  return this.http.get(`${this.baseUrl}/updateOrderStatuses`) as Observable<Order>;
}

addOrder(order:Order): void {
  console.log(order);
  this.http.post<Order>(this.baseUrl, order).subscribe((result) => {
    console.log(result);
  }, error => {
    console.log(error);
  }
  );
  
}
  
updateOrder(order:Order): Observable<any> {
  console.log(order);
  const tempVar: Observable<any> = this.http.put<Order>(this.baseUrl, order);
  tempVar.subscribe((result) => {
    console.log(result);
  }, error => {
    console.log(error);
  }
  )
  return tempVar;
}

deleteOrderById(id: number): Observable<any> {
  console.log("The ID to DELETE: ", id);
  const tempVar: Observable<any> = this.http.delete<Order>(this.baseUrl + "/" + id);
  tempVar.subscribe((result) => {
    console.log(result);
  }, error => {
    console.log(error);
  }
  )
  return tempVar;
}


}
