export class Order {
    constructor(
        public id: number,
        public ticker: string,
        public price: number,
        public status_code: number,
        public num_shares: number,
        public order_type: string,
        public time_of_day: string,
        public asset: string
        ) {
    }
}
