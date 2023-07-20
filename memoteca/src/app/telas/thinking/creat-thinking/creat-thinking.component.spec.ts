import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatThinkingComponent } from './creat-thinking.component';

describe('CreatThinkingComponent', () => {
  let component: CreatThinkingComponent;
  let fixture: ComponentFixture<CreatThinkingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatThinkingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatThinkingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
