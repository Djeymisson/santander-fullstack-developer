import { Component, Input, OnInit } from '@angular/core';
import { AbstractControl, FormGroup } from '@angular/forms';
import { ValidateFieldsService } from '../validate-fields.service';

@Component({
  selector: 'app-input-text',
  templateUrl: './input-text.component.html'
})
export class InputTextComponent {

  @Input() placeholder: string;
  @Input() formGroup: FormGroup;
  @Input() controlName: string;

  constructor(public validator: ValidateFieldsService) { }

  get formControl(): AbstractControl {
    return this.formGroup.controls[this.controlName];
  }
}
