export class Order {
    constructor(
        public id: number,
        public ticker: string,
        public price: number,
        public statusCode: number,
        public numberOfShares: number,
        public orderType: string,
        public timeOfDay: Date
        ) {
    }
}
