import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  numbers: Array<number> = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  @Input() rating: number;
  constructor() { }

  ngOnInit(): void {
  }

}
