package mx.com.geekflu.processing.movement;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import processing.core.PApplet;
import processing.core.PVector;


@Getter
@Setter
@Slf4j
public class Mover implements Movable {

  private PApplet sketch;
  private PVector location;
  private PVector acceleration;
  private PVector velocity;

  public Mover(PApplet sketch, PVector location, PVector acceleration, PVector velocity) {
    this.sketch = sketch;
    this.location = location;
    this.acceleration = acceleration;
    this.velocity = velocity;
  }

  public Mover(PApplet sketch) {
    this.sketch = sketch;
    this.location = new PVector(sketch.random(sketch.width), sketch.random(sketch.height));
    this.acceleration = new PVector(0.0001f, 0.001f);
    this.velocity = new PVector(sketch.random(-3, 3), sketch.random(-2, 2));
  }


  @Override
  public void update() {
    this.location.add(this.velocity);
    this.sketch.text("Velocidad = " + this.velocity.mag(), 20, 50);
  }

  @Override
  public void display() {
    this.sketch.stroke(0);
    this.sketch.fill(175);
    this.sketch.ellipse(this.location.x, this.location.y, 16, 16);
  }

  @Override
  public void checkEdges() {
    if (location.x > this.sketch.width) {
      location.x = 0;
    } else if (location.x < 0) {
      location.x = this.sketch.width;
    }

    if (location.y > this.sketch.height) {
      location.y = 0;
    } else if (location.y < 0) {
      location.y = this.sketch.height;
    }
  }
}
