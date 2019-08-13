import { Component, OnInit } from "@angular/core";
import { ClientService } from "app/services/client-service.service";
import { NgForm } from "@angular/forms";
import { Client } from "app/models/Client";
import { map } from "rxjs/operators";
import Swal from "sweetalert2";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: "app-client-add",
  templateUrl: "./client-add.component.html"
})
export class ClientAddComponent implements OnInit {
  title = "Create Client";
  public description: string;
  client: Client = new Client();

  public age: number;

  constructor(private _clientService: ClientService) {
    this.title = "Create Client";
    this.description = "Create new cliente in api Firebase.io";
  }

  ngOnInit() {}

  /**
   * Método para validar la edad
   * @param age
   */
  validateAge(age) {
    let dateString = this.client.birthdate;
    let newDate = new Date(dateString);

    if (this.client.birthdate) {
      var timeDiff = Math.abs(Date.now() - newDate.getTime());
      this.age = Math.ceil(timeDiff / (1000 * 3600 * 24) / 365);
      if (this.age >= 18) {
        return true;
      } else {
        return false;
      }
    }
  }

  /**
   * Método para crear un nuevo cliente
   */
  saveClient(form: NgForm) {
    if (form.valid) {
      if (this.validateAge(this.client.birthdate)) {
        this._clientService.createClient(this.client).subscribe(res => {
          console.log(res);

          Swal.fire({
            title: "Good job!",
            text: "Successful register!",
            type: "success"
          });
          form.reset();
        });
      } else {
        Swal.fire({
          title: "Error!!",
          text: "Age must be over 18!",
          type: "error"
        });
      }
    } else {
      Swal.fire({
        title: "Error!!",
        text: "You must validate the information to be entered!",
        type: "error"
      });
    }
  }
}
