package mx.com.geekflu.processing.movement;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import processing.core.PApplet;
import processing.core.PVector;

@Setter
@Getter
@Slf4j
public class ConstantAccelerationSketch extends PApplet {

  private Mover mover;

  @Override
  public void settings() {
    size(640, 360);
    var velocity = new PVector(0, 0);
    var location = new PVector((float) width / 2, (float) height / 2);
    var acceleration = new PVector(-0.001f, 0.01f);
    this.mover = new Mover(this, location, velocity, acceleration);
  }


  @Override
  public void draw() {
    background(255);
    getMover().update();
    getMover().checkEdges();
    getMover().display();
  }

  public static void main(String[] args) {
    var processingArgs = new String[]{"ConstantAccelerationSketch"};
    var accelerationSketch = new ConstantAccelerationSketch();
    PApplet.runSketch(processingArgs, accelerationSketch);
  }

}
