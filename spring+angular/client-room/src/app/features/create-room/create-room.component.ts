import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ValidateFieldsService } from 'src/app/shared/components/input-fields/validate-fields.service';
import { Room } from 'src/app/shared/models/room.model';
import { RoomService } from 'src/app/shared/services/room.service';
@Component({
	selector: 'app-create-room',
	templateUrl: './create-room.component.html',
	styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {

	id: number;
	form: FormGroup;
	room: Room = new Room();

	constructor(public validator: ValidateFieldsService,
		public dialog: MatDialog,
		private roomService: RoomService,
		private router: Router,
		private fb: FormBuilder,
		private activatedRoute: ActivatedRoute) { }

	ngOnInit() {
		this.id = this.activatedRoute.snapshot.params['id'];
		if (this.id) {
			this.roomService.getRoom(this.id)
				.subscribe(data => {
					this.room = data;
				}, error => console.log(error));
		} else {
			this.form = this.fb.group({
				name: [undefined, [Validators.required, Validators.minLength(2), Validators.maxLength(256)]],
				date: [undefined, [Validators.required]],
				startHour: [undefined, [Validators.required]],
				endHour: [undefined, [Validators.required]],
			});
		}
	}

	newRoom(): void {
		this.room = new Room();
	}

	onSubmit() {
		this.form.markAllAsTouched();
		if (this.form.invalid) {
			return;
		}

		this.room = this.form.getRawValue() as Room;

		if (this.id) {
			this.room.id = this.id;
			this.update();
		} else {
			this.save();
		}
	}

	save() {
		console.log(this.room);

		this.roomService.createRoom(this.room)
			.subscribe(
				data => console.log(data),
				error => console.log(error)
			);

		this.gotoList();
	}

	update(): void {
		this.roomService.updateRoom(this.id, this.room).subscribe(
			data => console.log(data),
			error => console.log(error)
		)

		this.gotoList()
	}

	gotoList() {
		this.router.navigate(['/rooms']);
	}
}
