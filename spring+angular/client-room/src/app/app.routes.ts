import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CreateRoomComponent } from "./features/create-room/create-room.component";
import { RoomDetailsComponent } from "./features/room-details/room-details.component";
import { RoomListComponent } from "./features/room-list/room-list.component";
import { UpdateRoomComponent } from "./features/update-room/update-room.component";


const routes: Routes = [
    { path: '', redirectTo: 'rooms', pathMatch: 'full' },
    { path: 'rooms', component: RoomListComponent },
    { path: 'add', component: CreateRoomComponent },
    { path: 'update/:id', component: UpdateRoomComponent },
    { path: 'details/:id', component: RoomDetailsComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutes { }
