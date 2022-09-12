import {Injectable} from '@angular/core';
import {IWord} from "./iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  words: IWord[] = [
    {id: '1', word: 'hi', mean: 'xin chao'},
    {id: '2', word: 'bye', mean: 'tam biet'}
  ]

  constructor() {
  }
  getAll()
  {
    return this.words;
  }

  findMeanById(id: string) {
    return this.words.find(item => item.id === id);
  }
}
