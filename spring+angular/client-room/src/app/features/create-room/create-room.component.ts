import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from 'src/app/shared/models/room.model';
import { RoomService } from 'src/app/shared/services/room.service';
@Component({
	selector: 'app-create-room',
	templateUrl: './create-room.component.html',
	styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {

	id: number;
	room: Room = new Room();

	constructor(private roomService: RoomService,
		private router: Router,
		private activatedRoute: ActivatedRoute) { }

	ngOnInit() {
		this.id = this.activatedRoute.snapshot.params['id'];
		if (this.id) {
			this.roomService.getRoom(this.id)
				.subscribe(data => {
					this.room = data;
				}, error => console.log(error));
		}
	}

	newRoom(): void {
		this.room = new Room();
	}

	save() {
		this.roomService.createRoom(this.room)
			.subscribe(
				data => console.log(data),
				error => console.log(error)
			);

		this.gotoList();
	}

	onSubmit() {
		this.save();
	}

	gotoList() {
		this.router.navigate(['/rooms']);
	}
}
