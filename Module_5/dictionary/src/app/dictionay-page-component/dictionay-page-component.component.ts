import { Component, OnInit } from '@angular/core';
import {IWord} from "../iword";
import {DictionaryServiceService} from "../dictionary-service.service";

@Component({
  selector: 'app-dictionay-page-component',
  templateUrl: './dictionay-page-component.component.html',
  styleUrls: ['./dictionay-page-component.component.css']
})
export class DictionayPageComponentComponent implements OnInit {
  words: IWord[] = [];
  constructor(private dictionaryService: DictionaryServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.words = this.dictionaryService.getAll();
  }
}
