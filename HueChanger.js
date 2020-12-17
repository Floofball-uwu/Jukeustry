//Sprite must be white or grayscale
const block = extendContent([blocktype], "name of block without .json", {
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