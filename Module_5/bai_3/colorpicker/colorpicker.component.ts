import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-colorpicker',
  templateUrl: './colorpicker.component.html',
  styleUrls: ['./colorpicker.component.css']
})
export class ColorpickerComponent implements OnInit {
  pickedColor = 'red';
  constructor() { }

  ngOnInit(): void {
  }

  change(color: string) {
    this.pickedColor = color;
  }
}
