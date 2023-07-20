import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CreatThinkingComponent } from "./telas/thinking/creat-thinking/creat-thinking.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'app-creat-thinking',
    pathMatch: 'full'
  },
  {
    path: 'app-creat-thinking',
    component: CreatThinkingComponent
  },
//   {
//     path: 'listarPensamento',
//     component: ListarPensamentoComponent
//   },
//   {
//     path: 'pensamentos/excluirPensamento/:id',
//     component: ExcluirPensamentoComponent
//   },
//   {
//     path: 'pensamentos/editarPensamento/:id',
//     component: EditarPensamentoComponent
//   }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule { }
