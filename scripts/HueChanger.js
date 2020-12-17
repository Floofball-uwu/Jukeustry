//Sprite must be white or grayscale
const block = extendContent(GenericSmelter, "jukeboxite-smelter", {
  load(){
    this.super$load();
    this.colorRegion = Core.atlas.find(this.name + "-color");
  }
});

block.buildType = () => {
  return extendContent(GenericSmelter.GenericSmelterBuild, block, {
    draw(){
      this.super$draw();
      Draw.color(Color.valueOf("ff0000").shiftHue(Time.time));
      Draw.rect(block.colorRegion, this.x, this.y);
      Draw.reset();
    }
  });
}
