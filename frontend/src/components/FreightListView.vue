<template>

    <v-data-table
        :headers="headers"
        :items="freightList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FreightListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            freightList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/freightLists'))

            temp.data._embedded.freightLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.freightList = temp.data._embedded.freightLists;
        },
        methods: {
        }
    }
</script>

