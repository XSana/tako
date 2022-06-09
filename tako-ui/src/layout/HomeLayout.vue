<template>
  <div>
    <el-container class="layout">
      <el-aside width="256px">Aside</el-aside>
      <el-container>
        <el-header>Header</el-header>
        <el-main>Main</el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>

export default {
  name: "HomeLayout",
  components: {},
  data() {
    return {}
  }
}
</script>

<style scoped>
.layout {
  height: 100vh;
}
</style>