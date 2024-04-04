<template>
    <v-card outlined>
        <v-card-title>
            SelectFreight
        </v-card-title>

        <v-card-text>
            <Number label="CarOwnerId" v-model="value.carOwnerId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="selectFreight"
            >
                SelectFreight
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'SelectFreightCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.carOwnerId = 0;
        },
        watch: {
        },
        methods: {
            selectFreight() {
                this.$emit('selectFreight', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

