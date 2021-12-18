import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-property-card',
  templateUrl: './property-card.component.html',
  styleUrls: ['./property-card.component.css']
})


export class PropertyCardComponent implements OnInit {
@Input() public property : any;
retrivedImage : any;
  constructor() { }

  ngOnInit(): void {

    this.retrivedImage='data:image/jpg;base64,'+this.property.image;
  }

}
