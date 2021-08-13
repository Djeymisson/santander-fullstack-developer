import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CreateRoomComponent } from './features/create-room/create-room.component';
import { RoomDetailsComponent } from './features/room-details/room-details.component';
import { UpdateRoomComponent } from './features/update-room/update-room.component';
import { RoomListComponent } from './features/room-list/room-list.component';
import { AppRoutes } from './app.routes';

@NgModule({
  declarations: [
    AppComponent,
    CreateRoomComponent,
    RoomDetailsComponent,
    UpdateRoomComponent,
    RoomListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutes,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
