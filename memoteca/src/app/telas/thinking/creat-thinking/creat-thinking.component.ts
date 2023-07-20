import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pensamento } from 'src/app/model/thinking';

@Component({
  selector: 'app-creat-thinking',
  templateUrl: './creat-thinking.component.html',
  styleUrls: ['./creat-thinking.component.css']
})
export class CreatThinkingComponent implements OnInit {

  pensamento: Pensamento = {

    conteudo: '',
    autoria: '',
    modelo: 'modelo1'
  }

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  criarPensamento() {
//    this.service.criar(this.pensamento).subscribe(() => {
    //  this.router.navigate(['/listarPensamento'])
  //  })
  }

  cancelar() {
    this.router.navigate(['/listarPensamento'])
  }

}
