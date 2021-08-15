import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Room } from 'src/app/shared/models/room.model';
import { RoomService } from 'src/app/shared/services/room.service';

@Component({
  selector: "app-room-list",
  templateUrl: "./room-list.component.html",
  styleUrls: ["./room-list.component.css"]
})
export class RoomListComponent implements OnInit {
  rooms: Observable<Room[]>;

  constructor(private roomService: RoomService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.rooms = this.roomService.getRoomsList();
  }

  deleteRoom(id: number) {
    this.roomService.deleteRoom(id)
      .subscribe(
        (data: any) => {
          this.reloadData();
        },
        (error: any) => console.log(error));
  }

  roomDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  updateRoom(id: number) {
    this.router.navigate(['add', id]);
  }
}