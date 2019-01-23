export class RatingVO {
    currentRating: number;
    laptopName: string;

    constructor(laptopname: string, currentRating: number) {
        this.laptopName = laptopname;
        this.currentRating = currentRating;
    }

}
