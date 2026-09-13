const express = require("express");
const app = express();
app.use(express.json());

app.post("/api/feedback", (req, res) => {
  console.log("Feedback:", req.body);
  res.status(201).json({ ok: true });
});

app.listen(3000, () => console.log("API listening on :3000"));