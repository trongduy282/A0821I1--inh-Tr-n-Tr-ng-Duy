import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.css']
})
export class CountdownComponent implements OnInit {
  message = '';
  remainingTime = 10;
  constructor() { }

  ngOnInit(): void {
  }
  start() {
    this.countDown();
  }
  private countDown() {
    window.setInterval(() => {
      this.remainingTime -= 1;
      if (this.remainingTime <= 0) {
        this.message = 'Blast off!';
        this.remainingTime = 0;
      } else {
        this.message = `${this.remainingTime} seconds and counting`;
      }
    }, 1000);
  }
}
