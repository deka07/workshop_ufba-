import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarComponent } from './Persona/listar/listar.component';
import { EditarComponent } from './Persona/editar/editar.component';
import { AdicionarComponent } from './Persona/adicionar/adicionar.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    EditarComponent,
    AdicionarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
