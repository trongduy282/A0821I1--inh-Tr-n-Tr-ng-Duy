import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../dictionary-service.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {IWord} from "../iword";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word: any;
  constructor(private dictionaryService: DictionaryServiceService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      console.log(id)
      this.word = this.dictionaryService.findMeanById(id);
      console.log(this.word);
    });
  }

}
