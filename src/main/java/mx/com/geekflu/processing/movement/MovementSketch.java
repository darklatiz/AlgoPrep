package mx.com.geekflu.processing.movement;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import processing.core.PApplet;

@Slf4j
@Getter
@Setter
public class MovementSketch extends PApplet {

  Mover mover;

  @Override
  public void settings() {
    size(640, 360);
    this.mover = new Mover(this);
  }


  @Override
  public void draw() {
    background(255);
    getMover().update();
    getMover().checkEdges();
    getMover().display();
  }

  public static void main(String[] args) {
    var processingArgs = new String[]{"AccelerationSketch"};
    var accelerationSketch = new MovementSketch();
    PApplet.runSketch(processingArgs, accelerationSketch);
  }

}
