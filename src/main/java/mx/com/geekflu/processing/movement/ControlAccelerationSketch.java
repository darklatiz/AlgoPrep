package mx.com.geekflu.processing.movement;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

@Getter
@Slf4j
public class ControlAccelerationSketch extends PApplet {

  private Mover mover;

  @Override
  public void settings() {
    size(640, 360);
    var velocity = new PVector(0.1f, 0.1f);
    var location = new PVector((float) width / 2, (float) height / 2);
    var acceleration = new PVector(0.001f, 0.001f);
    this.mover = new Mover(this, location, velocity, acceleration);
  }


  @Override
  public void draw() {
    background(255);
    getMover().update();
    getMover().checkEdges();
    getMover().display();
  }

  @Override
  public void keyPressed(KeyEvent event) {
    float currentMag = getMover().getAcceleration().mag();
    if (event.getKeyCode() == UP) {
      log.info("Accelerating by 0.1");
      currentMag += 0.001;
      getMover().getAcceleration().setMag(currentMag);
    }else if (event.getKeyCode() == DOWN) {
      log.info("Key  DOWN pressed");
      currentMag -= 0.5;
      getMover().getAcceleration().setMag(currentMag);
    }
  }

  public static void main(String[] args) {
    var processingArgs = new String[]{"ControlAccelerationSketch"};
    var controlAccelerationSketch = new ControlAccelerationSketch();
    PApplet.runSketch(processingArgs, controlAccelerationSketch);
  }

}
