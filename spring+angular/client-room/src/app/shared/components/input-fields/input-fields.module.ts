import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { NgxMaterialTimepickerModule } from "ngx-material-timepicker";
import { MaterialModule } from "../../material/material.module";
import { InputDateComponent } from "./input-date/input-date.component";
import { InputTextComponent } from './input-text/input-text.component';
import { InputTimeComponent } from './input-time/input-time.component';

@NgModule({
    declarations: [
        InputDateComponent,
        InputTextComponent,
        InputTimeComponent
    ],
    imports: [
        CommonModule,
        MaterialModule,
        ReactiveFormsModule,
        FormsModule,
        NgxMaterialTimepickerModule
    ],
    exports: [
        InputDateComponent,
        InputTextComponent,
        InputTimeComponent
    ]
})
export class InputFieldsModule { }