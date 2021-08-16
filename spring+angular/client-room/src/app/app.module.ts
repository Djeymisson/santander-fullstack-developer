import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CreateRoomComponent } from './features/create-room/create-room.component';
import { RoomDetailsComponent } from './features/room-details/room-details.component';
import { RoomListComponent } from './features/room-list/room-list.component';
import { AppRoutes } from './app.routes';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material/material.module';
import { CommonModule } from '@angular/common';
import { InputFieldsModule } from './shared/components/input-fields/input-fields.module';

@NgModule({
  declarations: [
    AppComponent,
    CreateRoomComponent,
    RoomDetailsComponent,
    RoomListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutes,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    InputFieldsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
