import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ClientiPageRoutingModule } from './clienti-routing.module';

import { ClientiPage } from './clienti.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ClientiPageRoutingModule
  ],
  declarations: [ClientiPage]
})
export class ClientiPageModule {}
