import {Component, OnInit} from '@angular/core';
import { io } from 'socket.io-client';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit{
  code: string | undefined;
  private socket: any;

  constructor() {
  }

  ngOnInit() {
    this.socket = io('http://192.168.1.134:7777', {transports: ['websocket']});
  }

  sendCode() {
    this.socket.emit('sendCode', this.code);
  }
}
