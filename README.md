# Shennv_piguan
java opencv + ffmpeg

### step 1: video to images:
```
ffmpeg -i piguan.mp4 -vf fps=21 out%d.png
```
*piguan.mp4 is the source video file*

### step 2: opencv border detection:
input files: out%d.png
output files: piguan%d.png

### step 3: images to video:
```
ffmpeg -r 21 -i piguan%d.png -vcodec libx264 piguan.mp4
```
